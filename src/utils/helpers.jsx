export class AppHelpers {
    static getStatusDetails(status) {
      switch (status) {
        case 'inProgress':
          return { description: 'Em Andamento', color: '#0076D7' };
        case 'pending':
          return { description: 'Pendente', color: '#FF7A00' };
        case 'approved':
          return { description: 'Aprovado', color: '#0FAF00' };
        case 'completed':
          return { description: 'Concluído', color: '#F4AB43' };
        case 'rejected': // Ajustado o case 'rejected' para não repetir 'completed'
          return { description: 'Reprovado', color: '#E54F4F' };
        default:
          return { description: 'Status desconhecido', color: '#000' };
      }
    }
  }
  