<?php

Route::resource('products', 'ProductController');

Route::get('/', function () {
    return view('welcome');
});
