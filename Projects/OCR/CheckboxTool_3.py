import os
import cv2
import pygame
import numpy as np
import tkinter as tk
pygame.font.init()

dScale = 4
Left = 100
Right = 200
indexEdition = 0
Caps = False
hMin, wMin = 10, 10


def setMinimum(img_path):
    global hMin, wMin
    img = cv2.imread(img_path)
    img_size = img.shape
    im_size_min = np.min(img_size[0:2])
    im_size_max = np.max(img_size[0:2])

    im_scale = float(600) / float(im_size_min)
    if np.round(im_scale * im_size_max) > 1200:
        im_scale = float(1200) / float(im_size_max)
    new_h = int(img_size[0] * im_scale)
    new_w = int(img_size[1] * im_scale)

    new_h = new_h if new_h // 16 == 0 else (new_h // 16 + 1) * 16
    new_w = new_w if new_w // 16 == 0 else (new_w // 16 + 1) * 16
    print(new_w, new_h, im_scale)
    hMin = int(10 * img_size[0] / new_h)
    wMin = int(10 * img_size[1] / new_w)


class Box:
    dYY = 0
    dX = 0
    dY = 0
    Font = pygame.font.SysFont('Consolas', 12)

    def __init__(self, pos):
        self.posX = pos[0]
        self.posY = pos[1]
        self.stt = 0

    def create(self, pos):
        self.dX = pos[0] - self.posX
        self.dY = pos[1] - self.posY

    def done(self, x, y, Scale):
        print(x, y)
        dX = self.dX
        dY = self.dY
        pX = self.posX
        pY = self.posY
        if dX < 0:
            pX = pX + dX
            dX = -dX
        if dY < 0:
            pY = pY + dY
            dY = -dY

        self.dX = int(dX * Scale)
        self.dY = int(dY * Scale)
        self.posX = int((pX - x) * Scale)
        self.posY = int((pY - y) * Scale)
        self.stt = 1

    def draw(self, win, x, y, scl, last, ii):
        scl = 1/scl
        x1 = x + int(self.posX * scl)
        y1 = y + int(self.posY * scl)
        x2 = x + int((self.posX + self.dX) * scl)
        y2 = y + int((self.posY + self.dYY) * scl)
        y3 = y + int((self.posY + self.dYY + self.dY) * scl)
        y4 = y + int((self.posY + self.dY) * scl)
        Polys = [(x1, y1), (x2, y2), (x2, y3), (x1, y4)]

        pygame.draw.polygon(win, (0, 0, 255), Polys, 1)
        if Caps:
            if indexEdition == ii:
                pygame.draw.polygon(win, (0, 255, 0), Polys, 1)
        elif last:
            pygame.draw.polygon(win, (0, 255, 0), Polys, 1)

    def info(self, win, ind, x, y):
        ch = str(ind) + ": " + str(self.posX) + ',' + str(self.posY) + ',' + str(self.dX) + ',' + str(self.dY) + ',' + str(self.dYY)
        msg = self.Font.render(ch, True, (0, 0, 0))
        if Caps and ind == indexEdition:
            msg = self.Font.render(ch, True, (0, 0, 255))
        elif self.dY <= hMin or self.dX <= wMin:
            msg = self.Font.render(ch, True, (255, 0, 255))

        win.blit(msg, (x, y))


def saveBox(path, boxes):
    f = open(path, 'w')
    for box in boxes:
        if box.dX > wMin and box.dY > hMin:
            poly = []
            poly.append(box.posX)  # x1
            poly.append(box.posY)  # y1
            poly.append(box.posX + box.dX)
            poly.append(box.posY + box.dYY)
            poly.append(box.posX + box.dX)
            poly.append(box.posY + box.dYY + box.dY)
            poly.append(box.posX)
            poly.append(box.posY + box.dY)
            for pl in poly:
                f.write(str(pl) + ',')
            f.write('\n')


def loadBox(path, boxes):
    try:
        f = open(path, 'r')
        lines = f.read().split('\n')
        for line in lines:
            if line == '':
                break
            xy = line.split(',')
            box = Box((0, 0))
            box.posX = int(xy[0])
            box.posY = int(xy[1])
            box.dX = int(xy[2]) - int(xy[0])
            box.dY = int(xy[7]) - int(xy[1])
            box.dYY = int(xy[3]) - int(xy[1])
            box.stt = 1
            boxes.append(box)
    except:
        boxes = []


class Element:
    positionX = Left + 50
    positionY = 50
    preScale = dScale
    ind = 0
    d_list = 20
    d_box = 15
    p_btt = (10, 150)
    Next = pygame.image.load('tools/imgs/Next.png')
    Prev = pygame.image.load('tools/imgs/Prev.png')
    Done = pygame.image.load('tools/imgs/Done.png')
    Zoom = pygame.image.load('tools/imgs/Zoom.png')

    Font = pygame.font.SysFont('Microsoft Sans Serif', 10)

    def __init__(self, scr_size, boxes):
        self.listImg = os.listdir('imgs')
        self.img = pygame.image.load('imgs/' + self.listImg[self.ind])
        setMinimum('imgs/' + self.listImg[self.ind])
        img_size = self.img.get_size()
        wScl = int(img_size[0] / self.preScale)
        hScl = int(img_size[1] / self.preScale)
        SIZE = (wScl, hScl)
        self.imgScl = pygame.transform.scale(self.img, SIZE)
        print(self.listImg)

        self.name = self.listImg[self.ind][:-4]
        self.scr = scr_size
        self.p_list = (5, scr_size[1] - 200)
        self.p_box = scr_size[0] - Right + 10
        self.MAX = int(scr_size[1] / self.d_box)
        self.NUM = len(self.listImg)
        loadBox('label/gt_' + self.name + '.txt', boxes)

    def next(self, delta, boxes):
        saveBox('label/gt_' + self.name + '.txt', boxes)
        del boxes[:]

        self.preScale = dScale
        self.ind += delta
        if self.ind == self.NUM:
            self.ind = 0
        if self.ind == -1:
            self.ind = self.NUM - 1
        self.name = self.listImg[self.ind][:-4]
        self.img = pygame.image.load('imgs/' + self.listImg[self.ind])
        img_size = self.img.get_size()
        wScl = int(img_size[0] / self.preScale)
        hScl = int(img_size[1] / self.preScale)
        SIZE = (wScl, hScl)
        self.imgScl = pygame.transform.scale(self.img, SIZE)
        loadBox('label/gt_' + self.name + '.txt', boxes)
        self.positionX = 50 + Left
        self.positionY = 50
        setMinimum('imgs/' + self.listImg[self.ind])

    def draw(self, win):
        win.blit(self.imgScl, (self.positionX, self.positionY))

    def drawBolder(self, win, boxes):
        pygame.draw.rect(win, (255, 255, 255), (0, 0, Left, self.scr[0]))
        pygame.draw.rect(win, (255, 255, 255), (self.scr[0] - Right, 0, Right, self.scr[1]))

        win.blit(self.Next, (self.p_btt[0], self.p_btt[1]))
        win.blit(self.Prev, (self.p_btt[0], self.p_btt[1] + 50))
        win.blit(self.Done, (self.p_btt[0], self.p_btt[1] + 100))
        win.blit(self.Zoom, (self.p_btt[0], self.p_btt[1] + 200))

        msg = '1:' + str(self.preScale) + ' - ' + str(dScale) + ' - ' + str(self.ind) + '/' + str(len(self.listImg))
        msg += ' - ' + str(wMin) + '/' + str(hMin)
        ch = self.Font.render(msg, True, (0, 0, 255))
        win.blit(ch, (self.p_list[0], self.p_list[1] - self.d_list))
        for i in range(10):
            if i == 5:
                ch = self.Font.render(self.listImg[i + self.ind - 5][:-4], True, (255, 0, 0))
            else:
                iIndex = i + self.ind - 5
                if iIndex >= self.NUM:
                    iIndex -= self.NUM
                name = self.listImg[iIndex][:-4]
                bxx = []
                loadBox('label/gt_' + name + '.txt', bxx)
                if len(bxx) > 10:
                    ch = self.Font.render(self.listImg[iIndex][:-4], True, (0, 255, 0))
                else:
                    ch = self.Font.render(self.listImg[iIndex][:-4], True, (0, 0, 0))
            win.blit(ch, (self.p_list[0], self.p_list[1] + i * self.d_list))

        for box in boxes:
            if box.stt == 1:
                i = boxes.index(box)
                ii = i
                if Caps:
                    if indexEdition > self.MAX - 1:
                        ii = ii + self.MAX - len(boxes) - 1
                elif len(boxes) > self.MAX:
                    ii = i + self.MAX - len(boxes) - 1
                box.info(win, i, self.p_box, ii * self.d_box + 10)

    def zoom(self, Scale, Pos):
        img_size = self.img.get_size()
        wScl = int(img_size[0] / Scale)
        hScl = int(img_size[1] / Scale)
        SIZE = (wScl, hScl)
        self.imgScl = pygame.transform.scale(self.img, SIZE)

        sS = Scale / self.preScale
        dX = int((Pos[0] - self.positionX) / sS)
        dY = int((Pos[1] - self.positionY) / sS)
        self.positionX = Pos[0] - dX
        self.positionY = Pos[1] - dY
        self.preScale = Scale

    def move(self, val):
        if val == 0:
            self.positionX -= 50
        if val == 1:
            self.positionY -= 50
        if val == 2:
            self.positionX += 50
        if val == 3:
            self.positionY += 50


def inSide(pos, Start, Size):
    if Start[0] < pos[0] < Start[0] + Size[0]:
        if Start[1] < pos[1] < Start[1] + Size[1]:
            return 1
    return 0


class Events:
    Ctrl = False
    Shift = False
    Alt = False
    Holding = False
    posHold = (0, 0)
    key = True
    Scale = dScale
    posPre = (0, 0)
    CONT = True

    def __init__(self):
        pass

    def get(self, event, scr, boxes, element):
        global Caps, indexEdition
        Type = event.type
        # TouchDown Key
        if Type == 768:
            code = event.scancode
            if code == 224:
                self.Ctrl = True
            elif code == 225:
                self.Shift = True
            elif code == 226:
                self.Alt = True
            elif code == 57:
                if event.mod == 12288:
                    Caps = True
                    indexEdition = len(boxes) - 1
                else:
                    Caps = False
            # Tab
            elif Caps and code == 43:
                if self.Shift:
                    indexEdition += 1
                    if len(boxes) == indexEdition:
                        indexEdition = 0
                else:
                    indexEdition -= 1
                    if indexEdition < 0:
                        indexEdition = len(boxes) - 1
            if self.Ctrl:
                scl = int(self.Scale)
                if scl == 0:
                    scl = 1
                if code == 82:
                    boxes[-1].dYY -= scl
                if code == 81:
                    boxes[-1].dYY += scl
            elif self.Shift:
                if len(boxes):
                    scl = int(self.Scale)
                    if scl == 0:
                        scl = 1
                    box = boxes[-1]
                    if Caps:
                        box = boxes[indexEdition]
                    if code == 82:
                        box.dY -= scl
                    elif code == 81:
                        box.dY += scl
                    if code == 80:
                        box.dX -= scl
                    elif code == 79:
                        box.dX += scl
                    if code == 76:
                        del boxes[:]
            else:
                if len(boxes):
                    scl = int(self.Scale)
                    if scl == 0:
                        scl = 1
                    box = boxes[-1]
                    if Caps:
                        box = boxes[indexEdition]
                    if code == 82:
                        box.posY -= scl
                    elif code == 81:
                        box.posY += scl
                    if code == 80:
                        box.posX -= scl
                    elif code == 79:
                        box.posX += scl
                    elif code == 76:
                        if Caps:
                            del boxes[indexEdition]
                            if indexEdition == len(boxes):
                                indexEdition = 0
                        else:
                            del boxes[-1]

        # TouchUp Key
        if Type == 769:
            if event.scancode == 224:
                self.Ctrl = False
            elif event.scancode == 225:
                self.Shift = False
            elif event.scancode == 226:
                self.Alt = False
            return
        # Roll Wheel
        if Type == 1027:
            dy = event.y
            if self.Ctrl:
                if dy == -1:
                    if self.Scale < 32:
                        self.Scale *= 2
                else:
                    if self.Scale > 0.25:
                        self.Scale /= 2
                element.zoom(self.Scale, self.posPre)
            elif self.Shift:
                if dy == -1:
                    element.move(0)
                else:
                    element.move(2)
            elif self.Alt:
                if len(boxes):
                    box = boxes[-1]
                    if Caps:
                        box = boxes[indexEdition]
                    scl = int(self.Scale)
                    if scl == 0:
                        scl = 1
                    scl *= 3
                    if dy == -1:
                        box.dYY -= scl
                    elif dy == 1:
                        box.dYY += scl

            else:
                if dy == -1:
                    element.move(1)
                else:
                    element.move(3)
            return

        # Mouse touchdown
        if Type == 1025:
            pos = event.pos
            button = event.button
            if button == 3:
                scl = int(self.Scale)
                if scl == 0:
                    scl = 1
                scl *= 3
                if self.Ctrl:
                    boxes[-1].dYY -= scl
                else:
                    boxes[-1].dYY += scl

            if button == 1:
                if inSide(pos, (Left, 0), (scr[0] - Left - Right, scr[1])):
                    self.Holding = True
                    self.key = True
                    self.posHold = pos

                global dScale
                if inSide(pos, (10, 350), (40, 30)):
                    if dScale < 32:
                        dScale *= 2
                elif inSide(pos, (50, 350), (40, 30)):
                    if dScale > 0.25:
                        dScale /= 2

                if inSide(pos, element.p_btt, (80, 150)):
                    delta = pos[1] - element.p_btt[1]
                    if delta % 50 < 30:
                        delta = int(delta / 50)
                        if delta == 0:
                            element.next(1, boxes)
                        elif delta == 1:
                            element.next(-1, boxes)
                        else:
                            element.next(0, boxes)
                            self.CONT = False
                        self.Scale = dScale

        # Mouse touchUp
        if Type == 1026:
            if not self.key:
                boxes[-1].done(element.positionX, element.positionY, self.Scale)
            self.Holding = False
            self.key = True

        if Type == 1024:
            pos = event.pos
            if inSide(pos, (Left, 0), (scr[0] - Left - Right, scr[1])):
                if self.Holding and self.posHold != pos:
                    if self.key:
                        box = Box(self.posHold)
                        boxes.append(box)
                        self.key = False
                    boxes[-1].create(pos)
                self.posPre = pos


def scrSize():
    root = tk.Tk()
    scr = (root.winfo_screenwidth(), root.winfo_screenheight())
    return scr


def drawPos(win, scr, pos, stt):
    posX, posY = pos
    pygame.draw.line(win, (255, 0, 0), (Left, posY), (scr[0] - Right, posY))
    pygame.draw.line(win, (255, 0, 0), (posX, 0), (posX, scr[1]))


def Show(win, scr_size, element, boxes):
    element.draw(win)
    x = element.positionX
    y = element.positionY
    scl = element.preScale
    for box in boxes:
        if box.stt == 0:
            dX = box.dX
            dY = box.dY
            pX = box.posX
            pY = box.posY
            if dX < 0:
                pX = pX + dX
                dX = -dX
            if dY < 0:
                pY = pY + dY
                dY = -dY
            pygame.draw.rect(win, (255, 0, 0), (pX, pY, dX, dY), width=1)
        else:
            ii = boxes.index(box)
            if box == boxes[-1]:
                box.draw(win, x, y, scl, True, ii)
            else:
                box.draw(win, x, y, scl, False, ii)
    element.drawBolder(win, boxes)


def Mainframe(scr_size):
    win = pygame.display.set_mode(scr_size)
    pygame.display.set_caption('Checkbox Text')
    pygame.display.update()
    boxes = []
    element = Element(scr_size, boxes)
    Event = Events()
    Pos = (0, 0)
    dk = True
    stt = False

    while dk:
        for event in pygame.event.get():
            Event.get(event, scr_size, boxes, element)
            dk = Event.CONT
            if event.type == 1024:
                Pos = event.pos
            if event.type == pygame.QUIT:
                dk = False

        Show(win, scr_size, element, boxes)
        drawPos(win, scr_size, Pos, stt)
        pygame.display.update()
        win.fill((127, 127, 127))
    pygame.display.quit()


scr = scrSize()
print(scr)
Mainframe(scr)
