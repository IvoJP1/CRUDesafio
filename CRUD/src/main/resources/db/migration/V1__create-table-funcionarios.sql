CREATE TABLE funcionarios(
  id SERIAL PRIMARY KEY ,
  nome TEXT not null,
  img TEXT ,
  cpf TEXT not null ,
  email TEXT not null ,
  telefone TEXT not null ,
  endereco TEXT not null
);