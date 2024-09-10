import toastr from 'toastr';
import 'toastr/build/toastr.min.css'

toastr.options = {
  "closeButton": true,
  "debug": false,
  "newestOnTop": false,
  "progressBar": false,
  "positionClass": "toast-top-center",
  "preventDuplicates": false,
  "onclick": null,
  "showDuration": "300",
  "hideDuration": "1000",
  "timeOut": "3000",
  "extendedTimeOut": "1000",
  "showEasing": "swing",
  "hideEasing": "linear",
  "showMethod": "fadeIn",
  "hideMethod": "fadeOut"
}

export function success_message(message) {
  toastr.success(message);
}

export function info_message(message) {
  toastr.info(message);
}

export function warning_message(message) {
  toastr.warning(message);
}

export function error_message(message) {
  toastr.error(message);
}