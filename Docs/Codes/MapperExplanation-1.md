This is one of the most important concepts in building a professional online store!

To understand `reservedStock`, imagine a real-world Best Buy store.

### The Problem (Why we need it)
Imagine there is **only 1 PlayStation 5 left** in the whole store. It is sitting on the shelf.
1. **Customer A** walks in, grabs the PS5, puts it in their shopping cart, and walks toward the cash register.
2. **Customer B** walks in a minute later, goes to the shelf, sees it is empty, and leaves.

Did Customer A actual *buy* the PS5 yet? **No.** They haven't paid.
But can Customer B buy it? **No.** Because Customer A has it in their cart.

In the physical world, the item is physically off the shelf. But on a website, if you don't use `reservedStock`, **two people can click "Buy" on the last item at the exact same time.** Your system will accidentally charge both people, but you only have one PS5 to ship! That creates a very angry customer.

---

### The Solution: How `reservedStock` fixes this

In your database, you split the inventory into two buckets:
1. **`availableStock`**: Items sitting freely on the shelf. Anyone can add them to their cart.
2. **`reservedStock`**: Items currently sitting inside a customer's digital shopping cart while they type in their credit card.

#### Step-by-Step Example (Starting with 5 TVs)

**Step 1: Normal Day**
*   Available Stock = **5**
*   Reserved Stock = **0**
*   *(The website says: "5 left in stock!")*

**Step 2: A customer starts the checkout process**
A customer clicks "Proceed to Checkout" for **1 TV**. They are now slowly typing their address and credit card info. Behind the scenes, your code immediately does this math:
*   Available Stock = **4** *(5 minus 1)*
*   Reserved Stock = **1** *(0 plus 1)*
*   *(Now, if a second person looks at the website, it safely says: "4 left in stock!")*

**Step 3: Two things can happen now**

**Scenario A: The customer buys it successfully!**
The credit card goes through. The TV is boxed up and shipped. Your code completely deletes the TV from the system:
*   Available Stock = **4**
*   Reserved Stock = **0** *(The 1 reserved TV is gone forever)*

**Scenario B: The customer's credit card declines (or they close the window)**
The order failed. The customer didn't buy the TV. Your code takes the TV out of their digital cart and puts it back on the shelf:
*   Available Stock = **5** *(4 plus 1)*
*   Reserved Stock = **0** *(1 minus 1)*

### Summary
`reservedStock` acts as a **temporary holding room**. It hides the item from the public website for a few minutes to give the customer time to type their credit card information, guaranteeing that you never accidentally sell the same TV to two different people!