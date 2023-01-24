
setInputFilter(document.getElementById("emergencyContact"), function(value) {
  return /^\d*?\d*$/.test(value); // Allow digits and '.' only, using a RegExp
});