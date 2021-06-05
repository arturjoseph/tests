import 'dart:developer';

void main() {
  int cont = 10;
  
  while(cont <= 10){
    print("O valor do contador é $cont");
    cont++;
  }
  print("Finalizando o programa while!");

  do{
    print("O valor do contador é $cont");
    cont++;
  }while(cont <= 10);

  print("Finalizando o programa do while!");

  int contFor;
   for(contFor = 0; contFor <= 10; contFor++){
    print("O valor do contador é $contFor");
  }
  print("Finalizando o programa for");
  for(contFor = 10; contFor >= 0; contFor--){
    print("O valor do contador é $contFor");
  }
  print("Finalizando o programa for");
}