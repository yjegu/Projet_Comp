.rdata
.align 2
$LC0:
       .ascii	"%d\000"
       .align 2
L12:
       .ascii	"\012\000"
       .align 2
L15:
       .ascii	"^2 + \000"
       .align 2
L16:
       .ascii	"1^2 = \000"
       .align 2
L17:
       .ascii	"\012\000"
.text
# label main
# beginfunc 
	.align	2
	.globl main
	.ent main
main:
	 addiu	$sp,$sp,-88
	 sw	$31,16($29)
	 sw	$16,24($29)
	 sw	$17,28($29)
	 sw	$18,32($29)
	 sw	$19,36($29)
	 sw	$20,40($29)
	 sw	$21,44($29)
	 sw	$22,48($29)
	 sw	$23,52($29)
# var n
# var i
# var s
# n = 5
       li   $8, 5
# s = 0
       li   $9, 0
# i = n
       sw  $8,56($29)
# label L10
       sw  $8,60($29)
       sw  $9,64($29)
L10:
# ifz i goto L11
       lw  $8,60($29)
	beq  $8,0,L11
# var T_0
# T_0 = i * i
	mult $8, $8
	mflo $8
# var T_1
# T_1 = s + T_0
       lw  $9,64($29)
	add $9, $9, $8
# s = T_1
       sw  $9,72($29)
# var T_2
# T_2 = i - 1
       lw  $11,60($29)
       li   $10, 1
	sub $10, $11, $10
# i = T_2
       sw  $10,76($29)
# goto L10
       sw  $8,68($29)
       sw  $9,64($29)
       sw  $10,60($29)
	j  L10
# label L11
L11:
# arg L12
       lui   $8,%hi(L12)
       addiu   $8,$8,%lo(L12)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# i = n
       lw  $8,56($29)
# label L13
       sw  $8,60($29)
L13:
# var T_3
# T_3 = i - 1
       lw  $9,60($29)
       li   $8, 1
	sub $8, $9, $8
# ifz T_3 goto L14
       sw  $8,80($29)
	beq  $8,0,L14
# arg i
	 sw   $9,0($29)
	move   $4,$9
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L15
       lui   $8,%hi(L15)
       addiu   $8,$8,%lo(L15)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# var T_4
# T_4 = i - 1
       lw  $9,60($29)
       li   $8, 1
	sub $8, $9, $8
# i = T_4
       sw  $8,84($29)
# goto L13
       sw  $8,60($29)
	j  L13
# label L14
L14:
# arg L16
       lui   $8,%hi(L16)
       addiu   $8,$8,%lo(L16)
	 sw   $8,0($29)
	move   $4,$8
# call L4
	 jal   n_printf
	 nop
# arg s
       lw  $8,64($29)
	 sw   $8,0($29)
	move   $4,$8
# call L2
       move $5,$4
       lui   $4,%hi($LC0)
       addiu   $4,$4,%lo($LC0)
	 jal   n_printf
	 nop
# arg L17
       lui   $8,%hi(L17)
       addiu   $8,$8,%lo(L17)
	 sw   $8,0($29)
	move   $4,$8
# call L4
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
	 addiu	$sp,$sp,88
	 jr  $31
	 nop
	.end main
