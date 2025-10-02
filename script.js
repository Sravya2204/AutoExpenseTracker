let expenses = [];
let total = 0;

// Handle form submit
document.getElementById("expense-form").addEventListener("submit", function(event) {
  event.preventDefault();

  let category = document.getElementById("category").value;
  let amount = parseFloat(document.getElementById("amount").value);

  if (category && amount) {
    expenses.push({ category, amount });
    total += amount;

    updateTable();
    updateSummary();

    // Reset inputs
    document.getElementById("category").value = "";
    document.getElementById("amount").value = "";
  }
});

function updateTable() {
  let tableBody = document.querySelector("#expense-table tbody");
  tableBody.innerHTML = "";

  expenses.forEach(exp => {
    let row = `<tr><td>${exp.category}</td><td>₹${exp.amount}</td></tr>`;
    tableBody.innerHTML += row;
  });
}

function updateSummary() {
  document.getElementById("summary").innerText = "Total: ₹" + total;
}
