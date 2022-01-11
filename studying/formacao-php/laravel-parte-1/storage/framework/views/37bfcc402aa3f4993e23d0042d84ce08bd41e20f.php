<?php $__env->startSection('cabecalho'); ?>
    Adicionar Série
<?php $__env->stopSection(); ?>

<?php $__env->startSection('conteudo'); ?>
<?php if($errors->any()): ?>
    <div class="alert alert-danger">
        <ul>
            <?php $__currentLoopData = $errors->all(); $__env->addLoop($__currentLoopData); foreach($__currentLoopData as $error): $__env->incrementLoopIndices(); $loop = $__env->getLastLoop(); ?>
                <li><?php echo e($error); ?></li>
            <?php endforeach; $__env->popLoop(); $loop = $__env->getLastLoop(); ?>
        </ul>
    </div>
<?php endif; ?>

<form method="post">
    <?php echo csrf_field(); ?>
    <div class="form-group">
        <label for="nome" class="">Nome</label>
        <input type="text" class="form-control" name="nome" id="nome">
    </div>

    <button class="btn btn-primary">Adicionar</button>
</form>
<?php $__env->stopSection(); ?>
<?php echo $__env->make('layout', \Illuminate\Support\Arr::except(get_defined_vars(), ['__data', '__path']))->render(); ?>
<?php /* E:\vinicius-dias\1190-laravel-parte1\controle-series\resources\views/series/create.blade.php */ ?>