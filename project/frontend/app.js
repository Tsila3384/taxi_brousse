// Configuration API
const API_BASE_URL = 'http://localhost:8080/api';

// Entities mapping
const ENTITIES = {

    voitures: {
        name: 'Voitures',
        endpoint: 'voitures',
        idField: 'idVoiture',
        fields: [
            { name: 'immatriculation', label: 'Immatriculation', type: 'text', required: true },
            { name: 'nbPlace', label: 'Nombre de Places', type: 'text', required: true },
            { name: 'consommation', label: 'Consommation (L/100km)', type: 'number', step: '0.01', required: true }
        ]
    },
    clients: {
        name: 'Clients',
        endpoint: 'clients',
        idField: 'idClient',
        fields: [
            { name: 'nom', label: 'Nom', type: 'text', required: true },
            { name: 'telephone', label: 'Téléphone', type: 'tel', required: true }
        ]
    },
    employes: {
        name: 'Employés',
        endpoint: 'employes',
        idField: 'idEmploye',
        fields: [
            { name: 'nom', label: 'Nom', type: 'text', required: true },
            { name: 'telephone', label: 'Téléphone', type: 'text', required: true },
            { name: 'genre', label: 'Genre', type: 'select', required: true, endpoint: 'genres', displayField: 'libelle', idEndpointField: 'idGenre' }
        ]
    },
    voyages: {
        name: 'Voyages',
        endpoint: 'voyages',
        idField: 'idVoyage',
        fields: [
            { name: 'daty', label: 'Date du Voyage', type: 'datetime-local', required: true },
            { name: 'chauffeur', label: 'Chauffeur', type: 'select', required: true, endpoint: 'employes', displayField: 'nom', idEndpointField: 'idEmploye' },
            { name: 'aideChauffeur', label: 'Aide Chauffeur', type: 'select', required: false, endpoint: 'employes', displayField: 'nom', idEndpointField: 'idEmploye' },
            { name: 'typeVoyage', label: 'Type de Voyage', type: 'select', required: true, endpoint: 'type-voyages', displayField: 'libelle', idEndpointField: 'idTypeVoyage' },
            { name: 'voiture', label: 'Voiture', type: 'select', required: true, endpoint: 'voitures', displayField: 'immatriculation', idEndpointField: 'idVoiture' }
        ]
    },
    reservations: {
        name: 'Réservations',
        endpoint: 'reservations',
        idField: 'idReservation',
        fields: [
            { name: 'daty', label: 'Date de Réservation', type: 'date', required: true },
            { name: 'nbPersonnes', label: 'Nombre de Personnes', type: 'number', required: true },
            { name: 'voyage', label: 'Voyage', type: 'select', required: true, endpoint: 'voyages', displayField: 'idVoyage', idEndpointField: 'idVoyage' },
            { name: 'client', label: 'Client', type: 'select', required: true, endpoint: 'clients', displayField: 'nom', idEndpointField: 'idClient' },
            { name: 'statutPaiement', label: 'Statut Paiement', type: 'checkbox', required: false }
        ]
    },
    paiements: {
        name: 'Paiements',
        endpoint: 'paiements',
        idField: 'idPaiement',
        fields: [
            { name: 'daty', label: 'Date du Paiement', type: 'date', required: true },
            { name: 'montant', label: 'Montant', type: 'number', step: '0.01', required: true },
            { name: 'reservation', label: 'Réservation', type: 'select', required: true, endpoint: 'reservations', displayField: 'idReservation', idEndpointField: 'idReservation' },
            { name: 'typePaiement', label: 'Type de Paiement', type: 'select', required: true, endpoint: 'type-paiements', displayField: 'libelle', idEndpointField: 'idTypePaiement' },
            { name: 'caisse', label: 'Caisse', type: 'select', required: true, endpoint: 'caisses', displayField: 'libelle', idEndpointField: 'idCaisse' }
        ]
    },
    lieux: {
        name: 'Lieux',
        endpoint: 'lieux',
        idField: 'idLieu',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    genres: {
        name: 'Genres',
        endpoint: 'genres',
        idField: 'idGenre',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    places: {
        name: 'Places',
        endpoint: 'places',
        idField: 'idPlace',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true },
            { name: 'statut', label: 'Statut', type: 'checkbox', required: false }
        ]
    },
    utilisateurs: {
        name: 'Utilisateurs',
        endpoint: 'utilisateurs',
        idField: 'idUtilisateur',
        fields: [
            { name: 'nom', label: 'Nom', type: 'text', required: true },
            { name: 'mdp', label: 'Mot de passe', type: 'password', required: true }
        ]
    },
    itineraires: {
        name: 'Itinéraires',
        endpoint: 'itineraires',
        idField: 'idItineraire',
        fields: [
            { name: 'duree', label: 'Durée (HH:mm:ss)', type: 'time', required: true },
            { name: 'lieuDepart', label: 'Lieu Départ', type: 'select', required: true, endpoint: 'lieux', displayField: 'libelle', idEndpointField: 'idLieu' },
            { name: 'lieuArrivee', label: 'Lieu Arrivée', type: 'select', required: true, endpoint: 'lieux', displayField: 'libelle', idEndpointField: 'idLieu' }
        ]
    },
    typevoyages: {
        name: 'Types Voyage',
        endpoint: 'type-voyages',
        idField: 'idTypeVoyage',
        fields: [
            { name: 'prix', label: 'Prix', type: 'number', step: '0.01', required: true },
            { name: 'itineraire', label: 'Itinéraire', type: 'select', required: true, endpoint: 'itineraires', displayField: 'libelle', idEndpointField: 'idItineraire' }
        ]
    },
    typepaiements: {
        name: 'Types Paiement',
        endpoint: 'type-paiements',
        idField: 'idTypePaiement',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    typemouvements: {
        name: 'Types Mouvement',
        endpoint: 'type-mouvements',
        idField: 'idTypeMouvement',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    statuts: {
        name: 'Statuts',
        endpoint: 'statuts',
        idField: 'idStatut',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    etats: {
        name: 'États',
        endpoint: 'etats',
        idField: 'idEtat',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true }
        ]
    },
    caisses: {
        name: 'Caisses',
        endpoint: 'caisses',
        idField: 'idCaisse',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true },
            { name: 'solde', label: 'Solde', type: 'number', step: '0.01', required: true }
        ]
    },
    parametres: {
        name: 'Paramètres',
        endpoint: 'parametres',
        idField: 'idParametre',
        fields: [
            { name: 'libelle', label: 'Libellé', type: 'text', required: true },
            { name: 'valeur', label: 'Valeur', type: 'text', required: true }
        ]
    },
    entretiens: {
        name: 'Entretiens',
        endpoint: 'entretiens',
        idField: 'idEntretien',
        fields: [
            { name: 'voiture', label: 'Voiture', type: 'select', required: true, endpoint: 'voitures', displayField: 'immatriculation', idEndpointField: 'idVoiture' }
        ]
    },
    mouvements: {
        name: 'Mouvements',
        endpoint: 'mouvements',
        idField: 'idMouvement',
        fields: [
            { name: 'typeMouvement', label: 'Type Mouvement', type: 'select', required: true, endpoint: 'type-mouvements', displayField: 'libelle', idEndpointField: 'idTypeMouvement' },
            { name: 'caisse', label: 'Caisse', type: 'select', required: true, endpoint: 'caisses', displayField: 'libelle', idEndpointField: 'idCaisse' }
        ]
    }
};

let currentSection = 'dashboard';
let editingId = null;
let dataCache = {};

// Initialize
document.addEventListener('DOMContentLoaded', () => {
    console.log('Page loaded, initializing...');
    setupEventListeners();
    loadDashboard();
});

// Setup Event Listeners
function setupEventListeners() {
    // Navigation
    document.querySelectorAll('.nav-btn').forEach(btn => {
        btn.addEventListener('click', handleNavigation);
    });

    // Modal
    document.querySelector('.modal-close').addEventListener('click', closeModal);
    document.getElementById('cancel-btn').addEventListener('click', closeModal);
    document.getElementById('entity-form').addEventListener('submit', handleFormSubmit);

    // Add button
    document.getElementById('add-btn').addEventListener('click', () => {
        editingId = null;
        openModal();
    });

    // Search
    document.querySelectorAll('.search-input').forEach(input => {
        input.addEventListener('keyup', (e) => {
            const section = e.target.closest('.section');
            if (section) {
                const sectionId = section.id;
                filterTable(sectionId, e.target.value);
            }
        });
    });

    // Close modal on outside click
    document.getElementById('modal').addEventListener('click', (e) => {
        if (e.target.id === 'modal') closeModal();
    });
}

// Navigation Handler
function handleNavigation(e) {
    const section = e.currentTarget.dataset.section;
    document.querySelectorAll('.nav-btn').forEach(btn => btn.classList.remove('active'));
    document.querySelectorAll('.section').forEach(sec => sec.classList.remove('active'));

    e.currentTarget.classList.add('active');
    document.getElementById(section).classList.add('active');

    currentSection = section;
    updatePageTitle();
    updateAddButton();

    if (section !== 'dashboard') {
        loadSectionData(section);
    }
}

// Load Dashboard
function loadDashboard() {
    const stats = ['voitures', 'clients', 'employes', 'voyages', 'reservations', 'paiements', 'lieux', 'genres', 'places', 'utilisateurs', 'itineraires', 'typevoyages', 'typepaiements', 'typemouvements', 'statuts', 'etats', 'caisses', 'parametres', 'entretiens', 'mouvements'];
    
    stats.forEach(stat => {
        const entity = ENTITIES[stat];
        fetchData(entity.endpoint).then(data => {
            console.log(`${stat} data loaded:`, data);
            const statElement = document.getElementById(`stat-${stat}`);
            if (statElement) {
                statElement.textContent = data ? data.length : 0;
            }
        }).catch(err => {
            console.error(`Error loading ${stat}:`, err);
            const statElement = document.getElementById(`stat-${stat}`);
            if (statElement) {
                statElement.textContent = '0';
            }
        });
    });
}

// Load Section Data
function loadSectionData(section) {
    const entity = ENTITIES[section];
    const table = document.getElementById(`${section}-table`);
    
    console.log(`Loading ${section} from endpoint: ${entity.endpoint}`);
    
    fetchData(entity.endpoint).then(data => {
        console.log(`${section} data received:`, data);
        dataCache[section] = data || [];
        renderTable(section, dataCache[section]);
    }).catch(error => {
        console.error('Error loading data:', error);
        showToast('Erreur lors du chargement des données', 'error');
        table.innerHTML = '<tr class="empty-row"><td colspan="10">Erreur lors du chargement</td></tr>';
    });
}

// Fetch Data from API
async function fetchData(endpoint) {
    try {
        const url = `${API_BASE_URL}/${endpoint}`;
        console.log(`Fetching from: ${url}`);
        
        const response = await fetch(url, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        });
        
        console.log(`Response status: ${response.status}`);
        
        if (!response.ok) {
            throw new Error(`HTTP ${response.status} - ${response.statusText}`);
        }
        
        const data = await response.json();
        console.log(`Successfully fetched ${endpoint}:`, data);
        return data || [];
    } catch (error) {
        console.error(`Error fetching ${endpoint}:`, error);
        return [];
    }
}

// Render Table
function renderTable(section, data) {
    const table = document.getElementById(`${section}-table`);
    const entity = ENTITIES[section];

    if (!data || data.length === 0) {
        table.innerHTML = `<tr class="empty-row"><td colspan="10">Aucune donnée trouvée</td></tr>`;
        return;
    }

    table.innerHTML = data.map(item => {
        const itemId = item[entity.idField];
        const cells = getTableCells(section, item);
        return `
            <tr>
                <td>${itemId || 'N/A'}</td>
                ${cells}
                <td class="action-buttons">
                    <button class="btn btn-edit" onclick="editItem('${section}', ${itemId})">
                        ✏️ Modifier
                    </button>
                    <button class="btn btn-danger" onclick="deleteItem('${section}', ${itemId})">
                        🗑️ Supprimer
                    </button>
                </td>
            </tr>
        `;
    }).join('');
}

// Get Table Cells
function getTableCells(section, item) {
    switch (section) {
        case 'voitures':
            return `
                <td>${item.immatriculation || 'N/A'}</td>
                <td>${item.nbPlace || 'N/A'}</td>
                <td>${item.consommation || 'N/A'}</td>
            `;
        case 'clients':
            return `
                <td>${item.nom || 'N/A'}</td>
                <td>${item.telephone || 'N/A'}</td>
            `;
        case 'employes':
            return `
                <td>${item.nom || 'N/A'}</td>
                <td>${item.telephone || 'N/A'}</td>
                <td>${item.genre?.libelle || 'N/A'}</td>
            `;
        case 'voyages':
            return `
                <td>${formatDate(item.daty)}</td>
                <td>${item.chauffeur?.nom || 'N/A'}</td>
                <td>${item.aideChauffeur?.nom || 'N/A'}</td>
                <td>${item.voiture?.immatriculation || 'N/A'}</td>
            `;
        case 'reservations':
            return `
                <td>${formatDate(item.daty)}</td>
                <td>${item.client?.nom || 'N/A'}</td>
                <td>${item.voyage?.idVoyage || 'N/A'}</td>
                <td>${item.nbPersonnes || 'N/A'}</td>
                <td>${item.statutPaiement ? 'Payé' : 'En attente'}</td>
            `;
        case 'paiements':
            return `
                <td>${formatDate(item.daty)}</td>
                <td>${item.montant ? parseFloat(item.montant).toFixed(2) + ' €' : 'N/A'}</td>
                <td>${item.reservation?.idReservation || 'N/A'}</td>
                <td>${item.typePaiement?.libelle || 'N/A'}</td>
            `;
        case 'lieux':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'genres':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'places':
            return `
                <td>${item.libelle || 'N/A'}</td>
                <td>${item.statut ? '✅ Occupée' : '❌ Libre'}</td>
            `;
        case 'utilisateurs':
            return `
                <td>${item.nom || 'N/A'}</td>
                <td>••••••••</td>
            `;
        case 'itineraires':
            return `
                <td>${item.duree || 'N/A'}</td>
                <td>${item.lieuDepart?.libelle || 'N/A'}</td>
                <td>${item.lieuArrivee?.libelle || 'N/A'}</td>
            `;
        case 'typevoyages':
            return `
                <td>${item.prix ? parseFloat(item.prix).toFixed(2) + ' €' : 'N/A'}</td>
                <td>${item.itineraire?.idItineraire || 'N/A'}</td>
            `;
        case 'typepaiements':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'typemouvements':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'statuts':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'etats':
            return `<td>${item.libelle || 'N/A'}</td>`;
        case 'caisses':
            return `
                <td>${item.libelle || 'N/A'}</td>
                <td>${item.solde ? parseFloat(item.solde).toFixed(2) + ' €' : 'N/A'}</td>
            `;
        case 'parametres':
            return `
                <td>${item.libelle || 'N/A'}</td>
                <td>${item.valeur || 'N/A'}</td>
            `;
        case 'entretiens':
            return `<td>${item.voiture?.immatriculation || 'N/A'}</td>`;
        case 'mouvements':
            return `
                <td>${item.typeMouvement?.libelle || 'N/A'}</td>
                <td>${item.caisse?.libelle || 'N/A'}</td>
            `;
        default:
            return '';
    }
}

// Filter Table
function filterTable(section, searchTerm) {
    const table = document.getElementById(`${section}-table`);
    const rows = table.querySelectorAll('tr:not(.empty-row)');
    
    rows.forEach(row => {
        const text = row.innerText.toLowerCase();
        row.style.display = text.includes(searchTerm.toLowerCase()) ? '' : 'none';
    });

    const visibleRows = table.querySelectorAll('tr[style=""]').length;
    if (visibleRows === 0) {
        table.innerHTML = '<tr class="empty-row"><td colspan="10">Aucun résultat trouvé</td></tr>';
    }
}

// Edit Item
function editItem(section, id) {
    editingId = id;
    const data = dataCache[section];
    const entity = ENTITIES[section];
    const item = data.find(d => d[entity.idField] === id);
    
    openModal(item);
}

// Delete Item
async function deleteItem(section, id) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer cet élément ?')) return;

    const entity = ENTITIES[section];
    try {
        const response = await fetch(`${API_BASE_URL}/${entity.endpoint}/${id}`, {
            method: 'DELETE'
        });
        
        if (!response.ok) throw new Error(`HTTP ${response.status}`);
        
        showToast('Élément supprimé avec succès', 'success');
        loadSectionData(section);
    } catch (error) {
        console.error('Error deleting:', error);
        showToast('Erreur lors de la suppression', 'error');
    }
}

// Open Modal
function openModal(item = null) {
    const entity = ENTITIES[currentSection];
    document.getElementById('modal-title').textContent = 
        item ? `Modifier ${entity.name}` : `Ajouter ${entity.name}`;
    
    generateFormFields(entity.fields, item);
    document.getElementById('modal').classList.add('active');
}

// Close Modal
function closeModal() {
    document.getElementById('modal').classList.remove('active');
    document.getElementById('entity-form').reset();
    editingId = null;
}

// Generate Form Fields
async function generateFormFields(fields, item = null) {
    const container = document.getElementById('form-fields');
    container.innerHTML = '';

    for (const field of fields) {
        const group = document.createElement('div');
        group.className = 'form-group';
        
        if (field.type === 'select') {
            const label = document.createElement('label');
            label.textContent = field.label;
            
            const select = document.createElement('select');
            select.name = field.name;
            select.required = field.required;
            
            const options = await fetchData(field.endpoint);
            select.innerHTML = '<option value="">-- Sélectionner --</option>';
            
            options.forEach(opt => {
                const optElement = document.createElement('option');
                const idEndpointField = field.idEndpointField || 'id';
                const displayField = field.displayField || 'nom';
                const optValue = opt[idEndpointField];
                const optText = opt[displayField] || opt[idEndpointField];
                
                optElement.value = optValue;
                optElement.textContent = optText;
                select.appendChild(optElement);
            });
            
            if (item && item[field.name]) {
                const fieldValue = item[field.name];
                if (typeof fieldValue === 'object' && fieldValue !== null) {
                    const idEndpointField = field.idEndpointField || 'id';
                    select.value = fieldValue[idEndpointField];
                } else {
                    select.value = fieldValue;
                }
            }
            
            group.appendChild(label);
            group.appendChild(select);
        } else if (field.type === 'checkbox') {
            const label = document.createElement('label');
            label.textContent = field.label;
            label.style.display = 'flex';
            label.style.alignItems = 'center';
            label.style.gap = '8px';
            
            const input = document.createElement('input');
            input.type = 'checkbox';
            input.name = field.name;
            
            if (item && item[field.name]) {
                input.checked = item[field.name];
            }
            
            label.appendChild(input);
            group.appendChild(label);
        } else {
            const label = document.createElement('label');
            label.textContent = field.label;
            
            const input = document.createElement('input');
            input.type = field.type;
            input.name = field.name;
            input.required = field.required;
            if (field.step) input.step = field.step;
            
            if (item && item[field.name]) {
                let value = item[field.name];
                if (field.type === 'datetime-local' || field.type === 'date') {
                    // Format the date/datetime properly
                    if (typeof value === 'string') {
                        value = value.includes('T') ? value.split('.')[0] : value + 'T00:00';
                    }
                }
                input.value = value || '';
            }
            
            group.appendChild(label);
            group.appendChild(input);
        }
        
        container.appendChild(group);
    }
}

// Handle Form Submit
async function handleFormSubmit(e) {
    e.preventDefault();
    
    const entity = ENTITIES[currentSection];
    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData);

    // Convert select fields to objects with proper ID field
    entity.fields.forEach(field => {
        if (field.type === 'select' && data[field.name]) {
            const idField = field.idEndpointField || 'id';
            data[field.name] = { [idField]: parseInt(data[field.name]) };
        } else if (field.type === 'checkbox') {
            // Handle checkbox for boolean values
            data[field.name] = data[field.name] === 'on';
        }
    });

    try {
        const url = `${API_BASE_URL}/${entity.endpoint}`;
        const method = editingId ? 'PUT' : 'POST';
        const endpoint = editingId ? `${url}/${editingId}` : url;

        const response = await fetch(endpoint, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) throw new Error(`HTTP ${response.status}`);

        showToast(editingId ? 'Élément modifié avec succès' : 'Élément créé avec succès', 'success');
        closeModal();
        loadSectionData(currentSection);
        loadDashboard();
    } catch (error) {
        console.error('Error submitting:', error);
        showToast('Erreur lors de l\'enregistrement', 'error');
    }
}

// Update Page Title
function updatePageTitle() {
    const entity = ENTITIES[currentSection];
    document.getElementById('page-title').textContent = entity?.name || 'Tableau de Bord';
}

// Update Add Button
function updateAddButton() {
    const addBtn = document.getElementById('add-btn');
    addBtn.style.display = currentSection === 'dashboard' ? 'none' : 'inline-flex';
}

// Show Toast
function showToast(message, type = 'info') {
    const toast = document.getElementById('toast');
    toast.textContent = message;
    toast.className = `toast ${type} active`;
    
    setTimeout(() => {
        toast.classList.remove('active');
    }, 3000);
}

// Format Date
function formatDate(dateString) {
    if (!dateString) return 'N/A';
    const date = new Date(dateString);
    return date.toLocaleDateString('fr-FR', { 
        year: 'numeric', 
        month: '2-digit', 
        day: '2-digit',
        hour: '2-digit',
        minute: '2-digit'
    });
}
