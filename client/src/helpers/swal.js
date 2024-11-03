import Swal from 'sweetalert2/dist/sweetalert2.js'
import 'sweetalert2/src/sweetalert2.scss'
import { translate } from '../configs/i18n'

export const dialog = (title, icon, text, confirmButtonText = translate('Button.Title.Ok'), showCancelButton = false) => {
    Swal.fire({
        title: title,
        text: text,
        icon: icon,
        showCancelButton: showCancelButton,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: confirmButtonText
    })
}

export const dialogConfirm = (title, text, callback, confirmButtonText = translate('Button.Title.Confirm')) => {
    Swal.fire({
        title: title,
        text: text,
        icon: "question",
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: confirmButtonText,
        cancelButtonText: translate('Button.Title.Cancel'),
        preConfirm: async () => {
            callback()
        }
    })
}