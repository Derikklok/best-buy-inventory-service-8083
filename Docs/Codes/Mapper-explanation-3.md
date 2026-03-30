That is a brilliant question! You are thinking exactly like a senior software engineer by asking, *"What about the other side of the `if` statement?"*

Let's stick to our **Warehouse Worker and Boss (Clipboard)** analogy.

### The Short Answer
If the Boss (the Angular frontend/Admin) *does* write a number in the "Reserved Stock" box on the instruction sheet, the worker grabs their eraser, wipes away whatever the old reserved number was, and **overwrites it** with the boss's new number.

### How the code does it:
```bash
if (dto.getReservedStock() != null) {
    inventory.setReservedStock(dto.getReservedStock());
}
```
If the boss writes the number `0` on the sheet:
1. The code asks: *"Is the reserved stock box filled out?"* (`!= null`).
2. The answer is **Yes** (it has a `0` in it).
3. The code goes inside the bracket and says: *"Okay, set the database clipboard's reserved stock to exactly `0`."*

### Real-World Example: Why would the boss do this?

Why would an Admin or the system ever need to manually change the `reservedStock` using this form?

**Scenario: The "Ghost Cart" Glitch**
Imagine a customer put 2 TVs in their digital shopping cart. The system correctly moved 2 TVs into `reservedStock`.
But then, the customer's laptop battery died, and their internet disconnected before they could pay or cancel.

To the database, those 2 TVs are permanently stuck in "reserved" limbo! Nobody else can buy them.

A Store Admin notices this. They open their Admin Dashboard screen (in Angular), watch at the TV inventory, and say: *"Those 2 TVs have been reserved for 3 days. I am canceling that."*

The Admin fills out the update form:
*   Available Stock: `10`
*   Reserved Stock: `0` *(They manually force it to zero)*

When the form hits your Java backend, your code sees that the `ReservedStock` box has a `0` in it. It overwrites the database, clearing out the "Ghost Carts" and making those TVs available for real customers to buy again!