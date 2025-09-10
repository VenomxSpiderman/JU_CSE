.model small
.stack 100h
.data 
    prompt db 13,10,"Thanks for initiating $"
    promptter db 13,10,"Terminating!!!$"

.code
   main proc
          mov ax,@data                                ;for moving data to data segment
          mov ds,ax
          
          xor bx,bx                                   ;initially bx value is equal to 0
          mov cl,4      
          
          lea dx, prompt                              ;show prompt
          mov ah, 9
          int 21h

          lea dx, promptter                          ;show terminating prompt
          mov ah, 9
          int 21h 

          mov ah, 4ch                               ;return control to dos
          int 21h
      
      
    main endp
   end main
