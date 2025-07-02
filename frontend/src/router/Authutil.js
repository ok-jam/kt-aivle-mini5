export const loginUser = (user) => {
  localStorage.setItem("user", JSON.stringify(user));
};

export const logoutUser = () => {
  localStorage.removeItem("userId");
};

export const getCurrentUser = () => {
  const user = localStorage.getItem("userId");
  return user ? user : null;
};