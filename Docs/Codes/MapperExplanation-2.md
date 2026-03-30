This code perfectly connects to the `reservedStock` explanation we just talked about!

Let's look at this specific code and see how it acts as a **smart safety feature** for your warehouse.

Imagine a Warehouse Worker holding the physical **Clipboard** (the `Inventory inventory` database record). Suddenly, their boss hands them a **New Instruction Sheet** (the `InventoryRequestDTO dto` from Angular) to update the numbers.

Here is what the worker does, line by line:

### 1. The Setup
```bash
public static void updateEntity(Inventory inventory, InventoryRequestDTO dto) {
```
*   **`void`**: The worker isn't creating a brand-new clipboard. They are just going to take an eraser, rub out the old numbers on the current clipboard, and write down the new ones.
*   **`Inventory inventory`**: The old clipboard (with the current database numbers).
*   **`InventoryRequestDTO dto`**: The new instruction sheet.

### 2. Updating the Main Shelf
```bash
    inventory.setAvailableStock(dto.getAvailableStock());
```
*   The worker looks at the instruction sheet, sees the new `availableStock` number, and immediately updates the clipboard.
*   *Example: A delivery truck drops off 10 new TVs. The boss's sheet says "Available Stock is now 20." The worker writes "20" on the clipboard.*

### 3. The Brilliant Safety Check
```bash
    if (dto.getReservedStock() != null) {
        inventory.setReservedStock(dto.getReservedStock());
    }
```
This `if` statement is the magic safety net!

Why? Imagine the boss's instruction sheet **only** said: *"Update Available Stock to 20."* They left the Reserved Stock box **blank** (`null`).

*   If you **didn't** have this `if` statement, your code would try to update the `reservedStock` to "blank".
*   Remember our example where a customer is currently typing in their credit card for a TV? If your code accidentally erased the `reservedStock` to zero right now, it would ruin their purchase and mess up the whole system!

Because of the `if (dto.getReservedStock() != null)` check, the worker says:
*"Ah, the boss left the reserved stock section blank on this form. That means I should **ignore it** and leave the ongoing customer orders exactly as they are!"*

### Summary
This small block of code ensures that when you update inventory, you don't accidentally wipe out the digital shopping carts of people who are currently trying to buy your items. It's a very professional way to handle database updates safely!