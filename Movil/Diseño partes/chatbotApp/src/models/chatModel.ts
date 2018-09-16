// src/models/chatModel.ts

export interface IChat {
    id : string;
    message : string;
    isMe : boolean;
    createdAt : string;
    type : 'human' | 'bot'   
}