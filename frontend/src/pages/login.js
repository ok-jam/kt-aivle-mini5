import { useState } from "react";
import { useNavigate } from 'react-router-dom';

import api from "../api"

const Login = ({ onClose }) => {
  const navigate = useNavigate();
  const [signInForm, setSignInForm] = useState({
      id: "",
      password: "",
  });
  const handleChange = (e) => {

      const { name, value } = e.target;
      setSignInForm((prev) => ({ ...prev, [name]: value }));
    };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { id, password } = si...