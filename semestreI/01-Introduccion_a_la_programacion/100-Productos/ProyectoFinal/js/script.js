class UserManager {
    constructor() {
        this.users = this.loadUsers();
    }

    loadUsers() {
        const data = localStorage.getItem('users');
        return data ? JSON.parse(data) : [];
    }

    saveUsers() {
        localStorage.setItem('users', JSON.stringify(this.users));
    }

    generateId() {
        return this.users.length > 0
            ? Math.max(...this.users.map(u => u.id)) + 1
            : 1;
    }

    createUser(name, email, phone, address) {
        const user = {
            id: this.generateId(),
            name,
            email,
            phone,
            address,
            created_at: new Date().toISOString().split('T')[0]
        };
        this.users.push(user);
        this.saveUsers();
        return user;
    }

    getUsers() {
        return this.users;
    }

    getUser(id) {
        return this.users.find(u => u.id === id);
    }

    updateUser(id, name, email, phone, address) {
        const index = this.users.findIndex(u => u.id === id);
        if (index !== -1) {
            this.users[index] = { ...this.users[index], name, email, phone, address };
            this.saveUsers();
            return true;
        }
        return false;
    }

    deleteUser(id) {
        this.users = this.users.filter(u => u.id !== id);
        this.saveUsers();
    }
}

const userManager = new UserManager();

function renderUsersTable() {
    const tbody = document.getElementById('users-table-body');
    if (!tbody) return;

    const users = userManager.getUsers();

    if (users.length === 0) {
        tbody.innerHTML = '<tr><td colspan="7" class="text-center text-secondary py-4">No users registered yet. Create your first user above.</td></tr>';
        return;
    }

    tbody.innerHTML = users.map(user => `
        <tr>
            <td>${user.id}</td>
            <td>${escapeHtml(user.name)}</td>
            <td>${escapeHtml(user.email)}</td>
            <td>${escapeHtml(user.phone)}</td>
            <td>${escapeHtml(user.address)}</td>
            <td>${user.created_at}</td>
            <td>
                <button class="btn btn-sm btn-outline-primary me-1" onclick="editUser(${user.id})" title="Edit user">Edit</button>
                <button class="btn btn-sm btn-danger" onclick="deleteUser(${user.id})" title="Delete user">Delete</button>
            </td>
        </tr>
    `).join('');
}

function escapeHtml(text) {
    if (!text) return '';
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
}

function handleCreateUser(event) {
    event.preventDefault();

    const name = document.getElementById('userName').value.trim();
    const email = document.getElementById('userEmail').value.trim();
    const phone = document.getElementById('userPhone').value.trim();
    const address = document.getElementById('userAddress').value.trim();

    if (!name || !email || !phone) {
        alert('Please fill in all required fields: Name, Email, and Phone.');
        return;
    }

    const userId = document.getElementById('userId').value;

    if (userId) {
        userManager.updateUser(parseInt(userId), name, email, phone, address);
    } else {
        userManager.createUser(name, email, phone, address);
    }

    document.getElementById('userForm').reset();
    document.getElementById('userId').value = '';
    document.getElementById('formTitle').textContent = 'New User';
    document.getElementById('submitBtn').textContent = 'Create User';
    renderUsersTable();
}

function editUser(id) {
    const user = userManager.getUser(id);
    if (!user) return;

    document.getElementById('userId').value = user.id;
    document.getElementById('userName').value = user.name;
    document.getElementById('userEmail').value = user.email;
    document.getElementById('userPhone').value = user.phone;
    document.getElementById('userAddress').value = user.address;
    document.getElementById('formTitle').textContent = 'Edit User';
    document.getElementById('submitBtn').textContent = 'Update User';

    window.scrollTo({ top: 0, behavior: 'smooth' });
}

function deleteUser(id) {
    if (confirm('Are you sure you want to delete this user?')) {
        userManager.deleteUser(id);
        renderUsersTable();
    }
}

function resetForm() {
    document.getElementById('userForm').reset();
    document.getElementById('userId').value = '';
    document.getElementById('formTitle').textContent = 'New User';
    document.getElementById('submitBtn').textContent = 'Create User';
}

function generateFibonacci() {
    const input = document.getElementById('fibInput');
    const result = document.getElementById('fibResult');
    const error = document.getElementById('fibError');

    const n = parseInt(input.value);

    if (isNaN(n) || n < 0) {
        error.textContent = 'Please enter a non-negative integer.';
        error.style.display = 'block';
        result.innerHTML = '';
        return;
    }

    if (n > 50) {
        error.textContent = 'Please enter a number less than or equal to 50.';
        error.style.display = 'block';
        result.innerHTML = '';
        return;
    }

    error.style.display = 'none';

    const sequence = [];
    let a = 0, b = 1;

    for (let i = 0; i <= n; i++) {
        sequence.push(a);
        [a, b] = [b, a + b];
    }

    result.innerHTML = sequence.map((num, i) =>
        `<span class="fib-number" title="F(${i}) = ${num}">${num}</span>`
    ).join('');
}

function handleContactSubmit(event) {
    event.preventDefault();

    const name = document.getElementById('contactName').value.trim();
    const email = document.getElementById('contactEmail').value.trim();
    const subject = document.getElementById('contactSubject').value.trim();
    const message = document.getElementById('contactMessage').value.trim();

    if (!name || !email || !subject || !message) {
        alert('Please fill in all fields.');
        return;
    }

    if (!isValidEmail(email)) {
        alert('Please enter a valid email address.');
        return;
    }

    alert('Thank you for your message! I will get back to you soon.');
    event.target.reset();
}

function isValidEmail(email) {
    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function handleFadeIn() {
    const elements = document.querySelectorAll('.fade-in');
    if (elements.length === 0) return;

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.classList.add('visible');
            }
        });
    }, { threshold: 0.1 });

    elements.forEach(el => observer.observe(el));
}

function setActiveNav() {
    const currentPage = window.location.pathname.split('/').pop() || 'index.html';
    const navLinks = document.querySelectorAll('.nav-link');

    navLinks.forEach(link => {
        const href = link.getAttribute('href');
        if (href === currentPage) {
            link.classList.add('active');
        } else {
            link.classList.remove('active');
        }
    });
}

document.addEventListener('DOMContentLoaded', function () {
    setActiveNav();
    handleFadeIn();

    if (document.getElementById('users-table-body')) {
        renderUsersTable();
    }
});
