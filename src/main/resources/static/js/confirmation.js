// confirmation.js
function showConfirmationModal(action, demandeId) {
    const modal = document.getElementById('confirmationModal');
    const actionButton = modal.querySelector('#actionButton');
    const form = modal.querySelector('form');

    if (action === 'Accepter') {
        actionButton.textContent = 'Accepter';

        form.action = '/demande/' + demandeId + '/accepter';
        
        // Affichage de la fenêtre modale uniquement pour le bouton "Accepter"
        modal.style.display = 'block';
    }
}

function hideConfirmationModal() {
    const modal = document.getElementById('confirmationModal');
    modal.style.display = 'none';
}
