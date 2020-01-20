void main() {
  print("Testando condicionais");
  int age = 15;
  bool adult = age >= 18;
  bool accompanied = true;
  if(age > 18){
    print("Você é maior de idade, pode entrar.");
  } else{
    print("Você é menor de idade, não pode entrar.");
  }
  print("Testando condicionais booleana");
  
  if(adult){
    print("Você é maior de idade, pode entrar.");
  } else{
      if(accompanied){
        print("Você é menor de idade, porem está acompanhado de um adulto, pode entrar.");
      }else{
        print("Você é menor de idade, não pode entrar.");
      }
  }

   print("Testando condicionais operadores logicos");
  
  if(age >= 16 || age >= 10 && accompanied){
    print("Você pode entrar.");
  } else{
        print("Você não pode entrar.");
  }
}