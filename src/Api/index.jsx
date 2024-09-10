import axios from 'axios';
import { error_message } from '../Components/Toast';

const Api = axios.create({
    baseURL: 'http://localhost:8080/api/',
});
export const exceptionNotificationAPI = (error) => {
    if (/500/.test(error.message)) {
        error_message('Failed to connect Web Service (500).');
    } else if (/404/.test(error.message)) {
        error_message(error.message);
    } else if (/400/.test(error.message)) {
        let notifications = error.response.data.notifications;
        if (notifications && notifications.length > 0) {
            notifications.forEach((not) => {
                error_message(not.message);
            });
        }
    } else {
        error_message(error.message);
    }
};

export default Api;