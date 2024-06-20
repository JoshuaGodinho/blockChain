# Blockchain Project - Implementing Transactions

## Overview
This project implements a blockchain in Java, focusing on transaction mechanisms as detailed in the tutorial "Creating Your First Blockchain with Java - Part 2: Transactions" by Programmer's Blockchain. The project covers key aspects such as transaction inputs and outputs, verification, and digital signatures, ensuring a secure and functional blockchain.

## Key Features
- **Transaction Inputs and Outputs**: Facilitates value transfers within the blockchain by creating unique transaction IDs and linking them to previous transactions.
- **Transaction Verification**: Ensures the integrity and security of the blockchain by verifying that all transaction inputs are unspent and match the required outputs, preventing double-spending and fraud.
- **Digital Signatures**: Adds a layer of security by using cryptographic techniques to sign transactions, ensuring that only the rightful owner can initiate a transfer.

## Implementation Details
1. **Transaction Inputs and Outputs**:
   - Implemented unique transaction IDs.
   - Linked transactions to previous ones for continuity and traceability.

2. **Transaction Verification**:
   - Verified that transaction inputs have not been previously spent.
   - Ensured transaction inputs match the required outputs.

3. **Digital Signatures**:
   - Used cryptographic techniques to sign transactions.
   - Ensured transactions could only be initiated by the rightful owner.

## Technologies Used
- **Programming Language**: Java
- **Cryptographic Libraries**: Java's built-in security libraries

## How to Run the Project
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/blockchain-project.git
