
setInputFilter(document.getElementById("sssNo"), function(value) {
  return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("philHealthNo"), function(value) {
  return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("pagibigNo"), function(value) {
  return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});

setInputFilter(document.getElementById("tinNo"), function(value) {
  return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});