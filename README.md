
# ☕ | Exceções em Java

Trago alguns exemplos de formas diferentes de como tratar os erros de exceções em Java, desde a pior maneira (Lógica de validação não delegada à reserva), a ruim (método retornando string), entretanto melhor que a primeira, e com a melhor maneira (tratamento de exceções) entre essas 3.

# 🧑‍💻 | Resoluções 


Clique aqui 👉 [Solução 1, 2 e 3](https://github.com/oalleeN/Exception-Java/commits/main/)

 __Solução 1 (muito ruim): lógica de validação no programa principal__
- Lógica de validação não delegada à reserva

__Solução 2 (ruim): método retornando string__ 
- A semântica da operação é prejudicada
    - Retornar string não tem nada a ver com atualização de reserva
    -  E se a operação tivesse que retornar um string?
- Ainda não é possível tratar exceções em construtores
- Ainda não há auxílio do compilador: o programador deve "lembrar" de verificar se houve erro
- A lógica fica estruturada em condicionais aninhadas

__Solução 3 (boa): tratamento de exceções__

- Uso de tratamento de exceções
- Execeção personalizada
