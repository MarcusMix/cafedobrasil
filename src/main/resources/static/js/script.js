async function fetchData() {
    try {
      const apiUrl = 'http://localhost:8080/produto/';
  
      const response = await fetch(apiUrl);
  
      if (!response.ok) {
        throw new Error('Não foi possível obter os dados da API.');
      }
  
      const data = await response.json();
  
      // Remova o loop 'forEach' e chame inserirDados para cada elemento
      data.forEach(element => {
        inserirDados(element);
      });
  
      console.log(data);
    } catch (error) {
      console.error('Ocorreu um erro:', error);
    }
  }



function inserirDados(data) {
// Crie um elemento de parágrafo
var h1 = document.createElement("h1");
var h4 = document.createElement("h4");
var p = document.createElement("p");

// Preencha o parágrafo com a propriedade 'nome' do objeto data
var produtoNome = document.createTextNode(data.nome);
var produtoPreco = document.createTextNode(data.valor);
var produtoQtd = document.createTextNode(data.qtde);
h1.appendChild(produtoNome);
p.appendChild(produtoPreco);
h4.appendChild(produtoQtd);

// Anexe o parágrafo ao corpo do documento HTML
// document.body.appendChild(paragrafo);

var divProduto = document.querySelector(".produto-lista");
divProduto.appendChild(h1);
divProduto.appendChild(h4);
divProduto.appendChild(p);
}


fetchData()