<?php

require 'TocadorDeMusica.php';

$musicas = new SplFixedArray(2);

$musicas[0] = "One Dance";
$musicas[1] = "Closer";

$musicas->setSize(4);

$musicas[2] = "rockstar";
$musicas[3] = "Love Yourself";

$tocador = new TocadorDeMusica();

$tocador->adicionarMusicas($musicas);

$tocador->adicionarMusicaNoComecoDaPlaylist("Havana");

$tocador->removerMusicaDoComecoDaPlaylist();

$tocador->removerMusicaDoFinalDaPlaylist();

$tocador->exibirMusicas();