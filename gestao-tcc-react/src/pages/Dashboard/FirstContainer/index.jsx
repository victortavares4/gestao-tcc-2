import React from "react";
import CardAtividades from "../../components/CardAtividades";
import './styles.css';
export function FirstContainer(){
    
    
  return (
    <div className="first-container">
    <CardAtividades data={document} />
      <CardAtividades data={document} />
      <CardAtividades data={document} />
    </div>
  );
};

export default FirstContainer;