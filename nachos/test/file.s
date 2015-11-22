.rdata
.align 2
$LC0:
       .ascii	"%d\000"
.text
# label main
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-76
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# label add
add:
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-76
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# var a
# var b
# var x
# var t
# t [ 0 ] = 1
       li   $8, 0
       li   $9,4
       mult   $8,$9
       mflo   $8
       add   $9,$29,60
       add   $8,$8,$9
       li   $9, 1
       sw  $9,0($8)
# t [ 1 ] = 2
       li   $8, 1
       li   $10,4
       mult   $8,$10
       mflo   $8
       add   $10,$29,60
       add   $8,$8,$10
       li   $10, 2
       sw  $10,0($8)
# t [ 2 ] = 3
       li   $8, 2
       li   $11,4
       mult   $8,$11
       mflo   $8
       add   $11,$29,60
       add   $8,$8,$11
       li   $11, 3
       sw  $11,0($8)
# var T_3
# T_3 = a + b
       lw  $12,76($29)
       lw  $8,80($29)
	add $8, $12, $8
# x = T_3
       sw  $8,72($29)
# return x
       move  $2,$8
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,76
	 jr  $31
	 nop
# endfunc 
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,76
	 jr  $31
	 nop
	.end main
# label main
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-76
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# var a
# var b
# var x
# var y
# x =  call L8
       addiu   $5,$29,56
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_read_int
	 nop
       sw   $2,56($29)
# ifz x goto L10
       sw  $2,56($29)
       move  $8,$2
	beq  $8,0,L10
# x = 2
       li   $9, 2
# goto L11
       sw  $9,56($29)
	j  L11
# label L10
L10:
# x = 0
       li   $8, 0
# label L11
       sw  $8,56($29)
L11:
# label L12
L12:
# var T_4
# arg x
       lw  $8,56($29)
	 sw   $8,0($29)
	move   $4,$8
# arg y
       lw  $9,60($29)
	 sw   $9,4($29)
	move   $5,$9
# T_4 =  call add
	 jal   add
	 nop
# var T_5
# T_5 = x + T_4
       lw  $9,56($29)
       move  $8,$2
	add $8, $9, $8
# ifnz T_5 goto L13
       sw  $2,64($29)
       sw  $8,68($29)
	bne  $8,0,L13
# var T_6
# T_6 = a - b
       lw  $11,76($29)
       lw  $10,80($29)
	sub $10, $11, $10
# x = T_6
       sw  $10,72($29)
# goto L12
       sw  $10,56($29)
	j  L12
# label L13
L13:
# arg x
       lw  $8,56($29)
	 sw   $8,0($29)
	move   $4,$8
# arg y
       lw  $9,60($29)
	 sw   $9,4($29)
	move   $5,$9
# call add
	 jal   add
	 nop
# arg x
       lw  $8,56($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# endfunc 
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,76
	 jr  $31
	 nop
	.end main
# endfunc 
	 lw	$16,20($29)
	 lw	$17,24($29)
	 lw	$18,28($29)
	 lw	$19,32($29)
	 lw	$20,36($29)
	 lw	$21,40($29)
	 lw	$22,44($29)
	 lw	$23,48($29)
	 lw	$31,16($29)
	 addiu	$sp,$sp,76
	 jr  $31
	 nop
	.end main
