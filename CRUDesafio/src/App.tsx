import { useEffect, useState } from 'react'
import './App.css'
import { FuncionarioData } from './interface/FuncionarioData';
import { Card } from './components/card/card';
import { useFuncionarioData } from './hooks/useFuncionarioData';
import { CreateModal } from './components/create-modal/create-modal';
import { UpdateModal } from './components/create-modal/update-modal';
import { DeleteModel } from './components/create-modal/delete-model';

function App() {
  const {data} = useFuncionarioData();
  const [isModalOpen, setIsModalOpen] = useState(false)
  const [isUpdateModalOpen, setIsUpdateModalOpen] = useState(false)
  const [isDeleteModelOpen, setIsDeleteModelOpen] = useState(false)
  const [selected, setSelected] = useState<number>(0) 
  const [cards, setCards] = useState<FuncionarioData[]|undefined>(data)
  const [refresh, setRefresh] = useState(false)

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev)
  }

  const handleUpdateModal = () =>{
    setIsUpdateModalOpen(false)
    window.location.reload()
  }

  const handleDeleteModal = () =>{
    setIsDeleteModelOpen(false)
    window.location.reload()
  }


  function getId(id: number){
    setSelected(id)
    setIsUpdateModalOpen(true)
  }

  function deleteId(id: number){
    setSelected(id)
    setIsDeleteModelOpen(true)
  }

  useEffect(()=>{
    data && setCards(data)
  },[refresh])


  return (
    <div className="container">
      <h1>Lista de Funcionários</h1>
      <div className="card-grid">
      {data?.map(funcionarioData => 
        <Card 
          key = {funcionarioData.id}
          getId = {getId}
          deleteId = {deleteId}
          id = {funcionarioData.id}
          nome={funcionarioData.nome} 
          cpf={funcionarioData.cpf}  
          email={funcionarioData.email} 
          img={funcionarioData.img} 
          telefone={funcionarioData.telefone} 
          endereco={funcionarioData.endereco} 
        />
      )}
      </div>
        {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
        {isUpdateModalOpen && <UpdateModal funcionarioId = {selected} closeModal={handleUpdateModal}/>}
        {isDeleteModelOpen && <DeleteModel funcionarioId={selected} closeModal={handleDeleteModal}/>}
        <button onClick={handleOpenModal}>Adicionar Funcionario</button>
    </div>
  )
}

export default App
