import React from "react";
import UpdateCard from "./UpdateCard";

const listaAtualizada = [
  {
    type: "Proposta",
    title: "Desenvolvimento de um Sistema de Recomendação Baseado em Machine Learning para E-commerce",
    description: "Implementar um sistema que sugira produtos aos usuários com base em suas interações anteriores, utilizando técnicas de aprendizado de máquina e processamento de dados.",
    student: { name: "Victor Hugo Tavares Brum", photo: "path_to_photo.jpg" },
    supervisor: "Kurt Molz",
    lastUpdate: "11:34 - seg - 26/08/2024",
    status: "Pendente",
  },
  {
    type: "Proposta",
    title: "Aplicação de Algoritmos de Visão Computacional para Diagnóstico Médico Automatizado",
    description: "Criar um sistema que utilize algoritmos de visão computacional para identificar doenças em imagens médicas, como raios-X ou ressonâncias magnéticas.",
    student: { name: "Victoria da Silva", photo: "path_to_photo.jpg" },
    supervisor: "Kurt Molz",
    lastUpdate: "11:34 - seg - 24/08/2024",
    status: "Pendente",
  },
  {
    type: "Trabalho de Conclusão",
    title: "Desenvolvimento de uma Plataforma de Ensino Gamificada Utilizando Realidade Aumentada",
    description: "Projetar e desenvolver uma plataforma educacional que combine elementos de gamificação com realidade aumentada para melhorar o engajamento e a retenção.",
    student: { name: "Victoria da Silva", photo: "path_to_photo.jpg" },
    supervisor: "Kurt Molz",
    lastUpdate: "11:34 - seg - 22/08/2024",
    status: "Em andamento",
  },
];

const listaAtualizacoes = () => {
  return (
    <div className="updates-list">
      <h2>Últimas Atualizações</h2>
      {listaAtualizada.map((update, index) => (
        <UpdateCard key={index} {...update} />
      ))}
    </div>
  );
};

export default listaAtualizacoes;
