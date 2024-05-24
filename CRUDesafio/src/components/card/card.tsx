import "./card.css"
interface CardProps {
    id?: number,
    getId: any,
    deleteId: any,
    nome: string,
    cpf: string,
    email: string,
    img: string,
    telefone: string,
    endereco: string

}

export function Card({id, getId, deleteId, nome, cpf, email, img} : CardProps) {

 
    return (
      <div className="card">
        
        <img src={img}/>
        <h2>{nome}</h2>
        <p className="letras"><b>CPF:</b> {cpf}</p>
        <p className="letras"><b>E-mail:</b> {email}</p>
        <div><a onClick={() =>getId(id)}>Editar  </a><a className="del" onClick={() => deleteId(id)}>    Deletar</a></div>
      </div>
    );
  }
