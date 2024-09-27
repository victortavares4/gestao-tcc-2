export class CommentModel{
    constructor(id, user, description){
        this.id = id;
        this.user =user;
        this.description = description;
    }
}

export default CommentModel;