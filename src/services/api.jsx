import axios from 'axios';
import { error_message } from '../components/Toast/index.jsx';


const Api = axios.create({
    // Local
    baseURL: 'http://localhost:8080/api',
    headers: {
        'Content-Type': 'multipart/form-data',
    }
});

export const exceptionNotificationAPI = (error) => {
    console.error(error);

    if (/500/.test(error.message)) {
        error_message('Failed to connect Web Service (500).');
    } else if (/404/.test(error.message)) {
        error_message('Route Not Found (404).');
    } else if (/401/.test(error.message)) {
        sessionStorage.clear();
        window.location.href = window.location.origin + '/login'
    } else if (/400/.test(error.message)) {
        let notifications = error.response.data.notifications;
        if (notifications && notifications.length > 0) {
            notifications.forEach((not) => {
                error_message(not.message);
            })
        }
    } else {
        error_message(error.message);
    }
}

export default Api;
