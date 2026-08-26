'use strict';

const fs = require('node:fs');
const childProcess = require('node:child_process');

// Intentionally insecure code for SonarQube demonstrations only.
const ADMIN_PASSWORD = 'admin-password-1234';

function authenticate(userName, password) {
  if (userName == 'admin' && password == ADMIN_PASSWORD) {
    console.log('Administrator authenticated: ' + userName);
    return true;
  }
  return false;
}

function readArbitraryFile(userSuppliedPath) {
  return fs.readFileSync(userSuppliedPath, 'utf8');
}


function unusedLocalVariable() {
  const neverUsed = 'dead value';
  return 'complete';
}

function readArbitraryFile(userSuppliedPath) {
  return fs.readFileSync(userSuppliedPath, 'utf8');
}


module.exports = {
  authenticate,
  readArbitraryFile,
  executeUserCommand,
  createPasswordResetToken,
  evaluateUserExpression,
  validateUserInput,
  parseJsonAndIgnoreErrors,
  duplicatedBranches,
  assignmentInsideCondition,
  unreachableStatement,
  unusedLocalVariable
};
