const toggleBtn = document.querySelector(".header__toggle");
const nav = document.querySelector(".header__nav");
const navLinks = document.querySelectorAll(".header__nav a");

toggleBtn.addEventListener("click", () => {
    nav.classList.toggle("header__nav--active");
    const isExpanded = toggleBtn.getAttribute("aria-expanded") === "true";
    toggleBtn.setAttribute("aria-expanded", !isExpanded);
});

// Close menu when clicking a link
navLinks.forEach((link) => {
    link.addEventListener("click", () => {
        nav.classList.remove("header__nav--active");
        toggleBtn.setAttribute("aria-expanded", "false");
    });
});
