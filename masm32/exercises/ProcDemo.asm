; From masm32\tutorial\console\demo2 
;     Build this with the "Project" menu using
;         "Console Assemble and Link"
; лллллллллллллллллллллллллллллллллл
    .486                                    ; create 32 bit code
    .model flat, stdcall                    ; 32 bit memory model
    option casemap :none                    ; case sensitive
 
    include \masm32\include\windows.inc     ; always first
    include \masm32\macros\macros.asm
  ; -----------------------------------------------------------------
  ; include files for function calls
  ; -----------------------------------------------------------------
    include \masm32\include\masm32.inc
    include \masm32\include\gdi32.inc
    include \masm32\include\user32.inc
    include \masm32\include\kernel32.inc
  ; ------------------------------------------------
  ; Library files that have definitions for function
  ; exports and tested reliable prebuilt code.
  ; ------------------------------------------------
    includelib \masm32\lib\masm32.lib
    includelib \masm32\lib\gdi32.lib
    includelib \masm32\lib\user32.lib
    includelib \masm32\lib\kernel32.lib
.code                       ; Tell MASM where the code starts

; лллллллллллллллллллллллллл

start:                ; The CODE entry point to the program
    call main                   ; branch to the "main" procedure
    exit
; ллллллллллллллллллллллллллллл

main proc
    print chr$("Hi, I am in the 'main' procedure",13,10)
    ret                         ; return to the next instruction after "call"
main endp

; ллллллллллллллллллллллллл

end start                       ; Tell MASM where the program ends
