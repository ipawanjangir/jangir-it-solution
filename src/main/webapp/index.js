

// window.addEventListener('scroll',() = > {
//     const nav = document.querySelector('.nabvar');

//     if(window.scrollY>50){
//         nav.style.background = '#1e293b';
    
//     }
//     else{
//         nav.style.background = '#0f172a';
//     }
// });

// Simple scroll effect for Navbar
window.addEventListener('scroll', () => {
    const nav = document.querySelector('.navbar');
    if (window.scrollY > 50) {
        nav.style.background = '#1e293b';
    } else {
        nav.style.background = '#0f172a';
    }
});

// Form Submission Alert
document.getElementById('contact-form').addEventListener('submit', function(e) {
    e.preventDefault();
    alert('Thank you, Jangir IT Solutions team will contact you soon!');
    this.reset();
});

    const contactForm = document.getElementById('contact-form');

    contactForm.addEventListener('submit', function(event) {
        event.preventDefault(); // Page ko reload hone se rokne ke liye
        
        // Popup message
        alert("Thank you for visiting Jangir IT Solution!");
        
        // Form ko clear karne ke liye
        contactForm.reset();
    });

     // Animation initialize
      AOS.init({
          duration: 800, // Animation kitni der chalegi (ms)
          offset: 120,   // Kitna scroll hone par start ho
          once: false    // Kya har baar scroll pe animation dikhe?
      });