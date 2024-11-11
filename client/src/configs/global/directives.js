import vFocus from "../../helpers/directives/v-focus";

export const globalDirectives = (app) => {
    app.directive('focus', vFocus);
}