// small helper script (currently only provides client-side form clearing)
function limpar() {
    document.getElementById('id').value = '';
    document.getElementById('nome').value = '';
    document.getElementById('email').value = '';
    document.getElementById('telefone').value = '';
    document.getElementById('btnSubmit').innerText = 'Cadastrar';
}
