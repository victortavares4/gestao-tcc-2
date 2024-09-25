export class TeacherModel{
    constructor(id,name,type,registration,students,photo){
        this.id = id;
        this.name = name;
        this.type = type;
        this.registration = registration;
        this.students = students;
        this.photo =photo;
    }
}

export default TeacherModel;