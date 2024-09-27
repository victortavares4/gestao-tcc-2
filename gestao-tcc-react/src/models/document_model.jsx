class DocumentModel {
    constructor(id, type, student, grades, professor, historic, meetings, lastSubmission, deadline, description, title, status, committee) {
      this.id = id; // Document ID
      this.type = type; // Document type (e.g., thesis, dissertation, etc.)
      this.student = student; // Student object
      this.grades = grades; // Array of grades
      this.professor = professor; // Professor object
      this.historic = historic; // Comment object (revision/comment history)
      this.meetings = meetings; // Array of Meeting objects
      this.lastSubmission = lastSubmission; // Date of the last document submission
      this.deadline = deadline; // Deadline for submission
      this.description = description; // Document description
      this.title = title; // Document title
      this.status = status; // Current status of the document (e.g., approved, pending)
      this.committee = committee; // Committee object (information about the evaluation committee)
    }
  }
  
  export default DocumentModel;
  