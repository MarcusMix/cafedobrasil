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
const elemento = `
    <div _id='${data.idProduto}' class='container-produto'>
        <h1>${data.nome}</h1>
        <h3>${data.valor}</h3>
        <h3>${data.qtde}</h3>
    </div>
`; 



// Anexe o parágrafo ao corpo do documento HTML
// document.body.appendChild(paragrafo);

var divProduto = document.querySelector(".produto-lista");
divProduto.insertAdjacentHTML('afterbegin',elemento);
}



fetchData()