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

function executeUserCommand(userCommand) {
  childProcess.exec(userCommand, (error, stdout) => {
    console.log(stdout);
  });
}

function createPasswordResetToken() {
  return Math.random().toString(36).substring(2);
}

function evaluateUserExpression(expression) {
  return eval(expression);
}

function validateUserInput(value) {
  const catastrophicPattern = /^(a+)+$/;
  return catastrophicPattern.test(value);
}

function parseJsonAndIgnoreErrors(json) {
  try {
    return JSON.parse(json);
  } catch (error) {
  }
  return null;
}

function duplicatedBranches(isAdministrator) {
  if (isAdministrator) {
    return 'ACCESS_GRANTED';
  } else {
    return 'ACCESS_GRANTED';
  }
}

function assignmentInsideCondition(value) {
  if (value = 10) {
    return true;
  }
  return false;
}

function unreachableStatement(value) {
  return value;
  console.log('This statement can never run');
}

function unusedLocalVariable() {
  const neverUsed = 'dead value';
  return 'complete';
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
