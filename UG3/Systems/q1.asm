.MODEL SMALL
.STACK 100H

.DATA
    NAME1 DB "Name: Tathagata Sur",0DH,0AH,"Program title: Write and test a MASM program to display your name and program title on the output screen$"
.CODE
    MOV AX, @DATA
    MOV DS, AX

    ; Display everything in one go
    LEA DX, NAME1
    MOV AH, 09H
    INT 21H

    ; Exit
    MOV AH, 4CH
    INT 21H
END
