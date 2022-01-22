<?php

Route::resource('products', 'ProductController');

Route::any('products.search', 'ProductController@search')->name('products.search');
