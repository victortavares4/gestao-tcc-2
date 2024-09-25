export class CommitteeModel {
    constructor(id, student,coordinator, professors,document){
        this.id = id;
        this.student = student;
        this.coordinator = coordinator;
        this.professors = professors;
        this.document = document;
    }
}