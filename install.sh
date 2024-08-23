#!/bin/bash

# Installation directory (e.g., /usr/local/bin)
INSTALL_DIR="/usr/local/bin"
APP_NAME="note"

# Create the bin directory if it doesn't exist
mkdir -p "$INSTALL_DIR"

# Copy the script to the installation directory
sudo cp "scripts/$APP_NAME" "$INSTALL_DIR/"

# Copy the compiled class files to a directory under /usr/local
sudo mkdir -p /usr/local/note/bin
sudo cp -r bin/* /usr/local/note/bin/

sudo mkdir -p /var/lib/note

# Ensure the script is executable
sudo chmod +x "$INSTALL_DIR/$APP_NAME"

# Notify the user
echo "$APP_NAME has been installed to $INSTALL_DIR"