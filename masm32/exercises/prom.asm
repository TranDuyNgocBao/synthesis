.486
.model flat, stdcall
option casemap :none

include \masm32\include\windows.inc
include \masm32\macros\macros.asm

include \masm32\include\masm32.inc
include \masm32\include\gdi32.inc
include \masm32\include\user32.inc
include \masm32\include\kernel32.inc

includelib \masm32\lib\masm32.lib
includelib \masm32\lib\gdi32.lib
includelib \masm32\lib\user32.lib
includelib \masm32\lib\kernel32.lib

.data
    xaukitu db "Bitch! Get in the back of my van you whore",0

.code

start:
    call main
    exit

main proc
    print OFFSET xaukitu    ; the "OFFSET" operator tells MASM that the text
                            ; data is at an OFFSET within the file which means
                            ; in this instance that it is in the .DATA section
    ret

main endp

end start

