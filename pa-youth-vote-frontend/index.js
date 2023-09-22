
// Dynamic menu item underlining based on active page
const currentPage = window.location.pathname.split('/').pop();
const menuItems = document.querySelectorAll('.header-content nav ul li');
const hostname = 'http://ec2-3-82-27-113.compute-1.amazonaws.com:8080'

menuItems.forEach(item => {
    const link = item.querySelector('a');
    if (link.getAttribute('href') === currentPage) {
        
        item.classList.add('active');
    }
})

// Dynamic mobile menu, make it so menu closes when menu item is clicked
menuItems.forEach(item => {
    item.addEventListener('click', () => {
        document.getElementById('menu-toggle').checked = false;
    });
});

// Form submission
if (currentPage === 'voter.html') {

    const voterForm = document.getElementById('voter-reg-form');
    
    voterForm.addEventListener('submit', async (e) => {
        e.preventDefault();
    
        const formData = new FormData(voterForm);
        const formDataObject = Object.fromEntries(formData);
        console.log(formDataObject);

        const jsonFormData = JSON.stringify(formDataObject);
        console.log('our form data', jsonFormData);
    
        try {
            const res = await fetch(`${hostname}/voter`, {
                method: 'POST',
                body: jsonFormData,
                headers: {
                    'Content-Type': 'application/json',
                    'Accept': 'application/json'
                },
            });
    
            if (res.ok) {
                const resData = await res.json();
                console.log('Form data submitted successfully', resData);
            }
            else {
                console.error('Error submitting form data', res.statusText);
            }
        }
        catch (error) {
            console.error('Error', error);
        }
    });
}



// Election Info code
async function displayElectionInfo() {
    try{
        const response = await fetch(`${hostname}/elections`);
        const data = await response.json();
        

        const electionsSection = document.getElementById('elections-section');
        const electionInfo = data.elections;

        electionInfo.forEach(election => {
            const electionCard = document.createElement('div');
            electionCard.classList.add('election-card');
            electionCard.innerHTML = `
                <h2>${election.name}</h2>
                <p><strong>Election Date: </strong> ${new Date(election.electionDay).toDateString()}</p>
                <p><strong>Division ID: </strong> ${election.ocdDivisionid}</p>
            `;

            electionsSection.appendChild(electionCard);
        })
    }
    catch (error) {
        console.error('Error fetching data', error);
    }
}
if(currentPage === 'elections.html') {
    displayElectionInfo();
}

