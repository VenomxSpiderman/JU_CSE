.model small
.stack 100h
.data
year db 0
month db 0
day db 0
hours db 0
minutes db 0
msg1 db 13,10,"System date ->: $"
msg2 db 13,10,"System Time ->: $"
msg3 db "hours$"
msg4 db "minutes$"
char1 db "/$"
endl db 13,10,"$"
.code
print macro msg
	push ax
	push dx
	mov ah, 09h
	lea dx, msg
	int 21h
	pop dx
	pop ax
endm

main proc

mov ax, @data
mov ds,ax

mov ah,2ah
int 21h

mov year,cx
mov month,dh
mov day, dl
mov ah,2ch
int 21h
mov hours,ch
mov minutes,cl

print msg1
mov ah,2
mov ax,year
call writenum
print char1
mov ax,month
call writenum
print char1
mov ah,2
mov dl,day
int 21h
print endl
print msg2

mov ah, 4ch
int 21h

main endp
writenum proc near
	push ax
	push bx
	push cx
	push dx
	xor cx,cx
	mov bx, 0ah
	@output:
		xor dx,dx
		div bx
		push dx
		inc cx
		or ax,ax
	jne @output
	mov ah, 02h
	@display:
		pop dx
		or dl, 30h
		int 21h
	loop @display
	pop dx
	pop cx
	pop bx
	pop ax
	ret
writenum endp
end main
