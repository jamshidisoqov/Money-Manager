package uz.uni_team.money_manager.ui.composables.verify

sealed class KeypadKey {
    data class Number(val number: Int) : KeypadKey()
    object Empty : KeypadKey()
    object Point: KeypadKey()
}

sealed class KeypadAction : KeypadKey() {
    object Delete : KeypadKey()
}