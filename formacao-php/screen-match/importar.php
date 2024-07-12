<?php

$caminhoArquivo = __DIR__ . '/filme.json';
$conteudoArquivo = file_get_contents($caminhoArquivo);
$filme = json_decode($conteudoArquivo,true);
var_dump($filme);