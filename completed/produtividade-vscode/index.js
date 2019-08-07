function helloWord() {
  console.log('Hello World!');
}

const saudacao = () => {
  const data = new Date();
  if (data.getHours() <= 12) return 'Bom dia!';
  if (data.getHours() <= 18) return 'Bom tarde!';
  return 'Boa noite';
};
helloWord();
console.log(`A saudação do momento é: ${saudacao()}`);
